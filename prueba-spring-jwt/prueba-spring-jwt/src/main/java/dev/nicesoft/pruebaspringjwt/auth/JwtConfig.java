package dev.nicesoft.pruebaspringjwt.auth;

public class JwtConfig {
	
	public static final String LLAVE_SECRETA = "ASDFKLHJ321243lajks.123123lkj1.fjlikas!";
	public static final String RSA_PRIVADA = 
			"-----BEGIN RSA PRIVATE KEY-----\n" + 
			"MIIEpAIBAAKCAQEA3w8B7FTQMfS7c4rdt2dJ+hqQN4pMPbwvPEiEAydRwrnyTrIq\n" + 
			"mBWlCs3ScvZ0KdgmRClBadNxPq9FHsqk+i4b9xTXl4PDeeQKKBV4iAswF9aSed3y\n" + 
			"SjPAqLgYUHWMF+AaNyyM9nXViCW29WmHRH+nHTB/hvB+0Ll5m3RfBDTofwvZaFZ5\n" + 
			"HcKa3m+EkoeKK8WI3DopvWNB2nXcX8Z2x2duMFnPjZrsemJtj/lJ8gIBDmXbk9/i\n" + 
			"VNRwP6i2qWaFnrLR1/tMmFH9Qtjlk3CCCE2RTNOnMM8dEz7U7kMh0NC1+5ltWTR9\n" + 
			"93LgZQF50DPIPHIrUOW/F7s52CKXN6sMCFvAFQIDAQABAoIBAQDF9tfKG2u7KmzD\n" + 
			"Gtez0iPBqJmd8UvA7qctZV5kPh0+KTF3zoAnAe68K/c+uKRYDtHHZKX9ef7jl0JN\n" + 
			"FaRdtVZ0bzb37aUrJMwuzv9uHh/MyE6vgd9rI4s1Mk3B+tEez3H0zcE9a07byj0a\n" + 
			"iVHX5UM3kLdd10t1i2b2JM2/OgWt2foUMyrSV0Ka3DhaIEsE2xMtcYZYsBCGBkmT\n" + 
			"znIY+8KNtzFMo7Ufn/HFK4GhARRQU8Np05wqpKHhsDad5Gd5QV7WLojZN+hTQ2sN\n" + 
			"3r5BQNyGmrXxw9pZVBMGKOjEQ8tDmOACxHNF3KOcd+8LRJG4uvE0IcYmeLdVCB/I\n" + 
			"A9GJuIFxAoGBAPP8yThRoUMJ2FYRdvUBawS4+Fah4bb6pX17n8OZM9ofaiN4xmT7\n" + 
			"/ct0aklWc5ZUKV9TXp5grotTJg58waDvKYuFf3KW6taLtk4Sc9q4DtDRLLq5bK6g\n" + 
			"iO6RQZz47Ef9EMQJoXJpEn+d1LtCHNUSk0xxmVqk0IRV9wHRPkvsSU23AoGBAOoK\n" + 
			"b1iKWOtNLNA3irTMGkqi4CIcVyk1PZQjaEEHla17WmaBbvS89TzfKp8o2GOS0UUI\n" + 
			"0smIk1g6ncSUia/cub3vaYdU5ughwSdDiURsincAHk2uZLg6Ij3sNV8cHFixxhIZ\n" + 
			"hhigdSVa3lCB2wjLfDOTbHWYcFx4ZtJ4+4773OCTAoGAFIvyKhL9wJaAqGbaHLHc\n" + 
			"4E3vY+RIDM+4xgN2JdOuAS1qE8ik9HYgHlUUak6kd0FpJoTvz+iWalc7OjcZW0Mo\n" + 
			"vX4liHHbHuwvEw4MwZuEa+Nhn+vjkiUkwupqmxx/UWSnV8rz1J2ymBqjgo2DvhHN\n" + 
			"Y7+hSXfds3dF0NpdI6mnVqsCgYBF4/XaV/4zzmkqiNuYIDddwIP0S8hPmwGXonc4\n" + 
			"rD4rf2HAqLhsx5zon7BHtVfhbG+oEPl5i5qMx3xjvwPbC6xAJyW5b0ZBXgsjYYy1\n" + 
			"bUBwRw3FnuWfCmU9XrOVgnyIlBYVQ6AC7K/vBtLK8exqFPIzKLxD5dDwHFiAU/az\n" + 
			"fU05lwKBgQDNtgpAJxhFqwMDgB2GTYsZHBY9OT6Zro0GkRYGXenSLrkcfUWHPGgX\n" + 
			"cw+K9NqKPRxMJI6yWkyIt5cjtUNZNRS3ohBDUbQ3hdrVOatl4mNFrbzXcH0j0F+A\n" + 
			"o0wSRM/nY+XcetHlQR5x5eRjGcsrI0Wl8OZNOjLoKxVKIVfVY8aWRw==\n" + 
			"-----END RSA PRIVATE KEY-----";
	
	public static final String RSA_PUBLICA = 
			"-----BEGIN PUBLIC KEY-----\n" + 
			"MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA3w8B7FTQMfS7c4rdt2dJ\n" + 
			"+hqQN4pMPbwvPEiEAydRwrnyTrIqmBWlCs3ScvZ0KdgmRClBadNxPq9FHsqk+i4b\n" + 
			"9xTXl4PDeeQKKBV4iAswF9aSed3ySjPAqLgYUHWMF+AaNyyM9nXViCW29WmHRH+n\n" + 
			"HTB/hvB+0Ll5m3RfBDTofwvZaFZ5HcKa3m+EkoeKK8WI3DopvWNB2nXcX8Z2x2du\n" + 
			"MFnPjZrsemJtj/lJ8gIBDmXbk9/iVNRwP6i2qWaFnrLR1/tMmFH9Qtjlk3CCCE2R\n" + 
			"TNOnMM8dEz7U7kMh0NC1+5ltWTR993LgZQF50DPIPHIrUOW/F7s52CKXN6sMCFvA\n" + 
			"FQIDAQAB\n" + 
			"-----END PUBLIC KEY-----";

}
