package com.architecture.promotions;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PromotionsApplicationTests {

	@Test
	public void contextLoads() {
		assertThat(1).isEqualTo(1);
	}

}
