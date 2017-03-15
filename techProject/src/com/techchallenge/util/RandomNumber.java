package com.techchallenge.util;

import java.util.concurrent.ThreadLocalRandom;

public class RandomNumber {
	
	public static int getRandNum(){
		
		int randomNum = ThreadLocalRandom.current().nextInt();
		return randomNum;
		
	}

}
