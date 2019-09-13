package com.origin.demo;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountInfoServiceImpl implements AccountInfoService {
	@Autowired
	AccountInfoRepo infoRepo;

	@Override
	public AccountInfo fetchRecordAccountInfo(int empId) {
		Optional<AccountInfo> option = infoRepo.findById(empId);
		if (option.isPresent()) {
			return option.get();
		}
		return new AccountInfo();
	}

}
