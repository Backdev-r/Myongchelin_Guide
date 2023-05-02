package com.example.demo;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MongodbProjectApplicationTests {

	@Autowired
	public UserServiceImpl userService;

	@Autowired
	public UserRepository userRepository;

	@Test
	void testRegisterNewUserAccount() throws EmailExistsException, UsernameExistsException {
		// given
		UserDto userDto = new UserDto("2","노무해", "12224");

		// when
		User savedUser = userService.registerNewUserAccount(userDto);

		// then
		Assertions.assertThat(savedUser).isNotNull();
		Assertions.assertThat(savedUser.getUsername()).isEqualTo(userDto.getUsername());

		User retrievedUser = userRepository.findByUsername(userDto.getUsername());
		Assertions.assertThat(retrievedUser).isNotNull();
		Assertions.assertThat(retrievedUser.getId()).isNotNull();
		Assertions.assertThat(retrievedUser.getUsername()).isEqualTo(userDto.getUsername());
		Assertions.assertThat(retrievedUser.getPassword()).isEqualTo(userDto.getPassword());
	}

}

