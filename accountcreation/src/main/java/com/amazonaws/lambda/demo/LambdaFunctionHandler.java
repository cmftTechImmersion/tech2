package com.amazonaws.lambda.demo;

import java.util.List;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class LambdaFunctionHandler implements RequestHandler<AccountCreation, String> {

    @Override
    public String handleRequest(AccountCreation input, Context context) {
        context.getLogger().log("Input: " + input);
        AccountCreationDao dao = new AccountCreationDao();
        List<AccountCreation> list = dao.persist(input);
        ObjectMapper mapper = new ObjectMapper();
        String jsonInString = "test";
		try {
			jsonInString = mapper.writeValueAsString(list);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
        return jsonInString;
    }

}
