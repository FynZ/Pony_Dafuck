package com.pony.services;

import com.pony.models.Token;
import com.pony.enumerations.TokenType;

public interface TokenService {

    Token generateToken(TokenType tokenType);
}