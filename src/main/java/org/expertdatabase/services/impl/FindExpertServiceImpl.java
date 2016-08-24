package org.expertdatabase.services.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.expertdatabase.entities.Expert;
import org.expertdatabase.entities.temp.CounterExpert;
import org.expertdatabase.repositories.FindExpertRepository;
import org.expertdatabase.repositories.provider.ProviderSql;
import org.expertdatabase.services.FindExpertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("FindExpertService")
public class FindExpertServiceImpl implements FindExpertService{

	@Autowired
	private FindExpertRepository expertRepository;
	

	@Override
	public Expert findExpertById(int expertId) {
		// TODO Auto-generated method stub
		return expertRepository.findExpertById(expertId);
	}
	
	@Override
	public Expert findExpertByName(String expertName) {
		// TODO Auto-generated method stub
		return expertRepository.findExpertByName(expertName);
	}

	@Override
	public ArrayList<Expert> findExpertBySkillId(List<String> skillId) {

		return expertRepository.findExpertBySkillId(skillId);
	}
	
	@Override
	public ArrayList<Expert> findExpertBySkillName(List<String> skillName) {
		// TODO Auto-generated method stub
		return expertRepository.findExpertBySkillName(skillName);
	}

	@Override
	public ArrayList<CounterExpert> countExpertBySkillName(List<String> skillName) {
		// TODO Auto-generated method stub
		return expertRepository.countExpertBySkillName(skillName);
	}

	@Override
	public ArrayList<CounterExpert> countExpertBySkillId(List<String> skillId) {
		
		return expertRepository.countExpertBySkillId(skillId);
	}

	@Override
	public ArrayList<Expert> findExpertByAgeLessThan(int age) {
		// TODO Auto-generated method stub
		return expertRepository.findExpertByAgeLessThan(age);
	}

	@Override
	public ArrayList<Expert> findExpertByAgeGreaterThan(int age) {
		// TODO Auto-generated method stub
		return expertRepository.findExpertByAgeGreaterThan(age);
	}

	@Override
	public ArrayList<Expert> findExpertByLanguageId(List<String> langugeId) {
		// TODO Auto-generated method stub
		return expertRepository.findExpertByLanguageId(langugeId);
	}

	@Override
	public ArrayList<Expert> findExpertByLanguageName(List<String> langugeName) {
		// TODO Auto-generated method stub
		return expertRepository.findExpertByLanguageName(langugeName);
	}

	@Override
	public ArrayList<Expert> findExpertByPositionId(List<String> positionId) {
		// TODO Auto-generated method stub
		return expertRepository.findExpertByPositionId(positionId);
	}

	@Override
	public ArrayList<Expert> findExpertByPositionName(List<String> positionName) {
		// TODO Auto-generated method stub
		return expertRepository.findExpertByPositionName(positionName);
	}

	@Override
	public ArrayList<Expert> findExpertBetweenAge(int age1, int age2) {
		// TODO Auto-generated method stub
		return expertRepository.findExpertBetweenAge(age1, age2);
	}
}
