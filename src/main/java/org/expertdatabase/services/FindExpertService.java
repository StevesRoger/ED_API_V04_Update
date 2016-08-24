package org.expertdatabase.services;

import java.util.ArrayList;
import java.util.List;

import org.expertdatabase.entities.Expert;
import org.expertdatabase.entities.Skill;
import org.expertdatabase.entities.temp.CounterExpert;

public interface FindExpertService {

	public Expert findExpertById(int expertId);
	
	public Expert findExpertByName(String expertName);
	
	public ArrayList<Expert>findExpertBySkillId(List<String> skillId);
	
	public ArrayList<CounterExpert> countExpertBySkillId(List<String> skillId);
	
	public ArrayList<Expert>findExpertBySkillName(List<String> skillName);
	
	public ArrayList<CounterExpert> countExpertBySkillName(List<String> skillName);
	
	public ArrayList<Expert>findExpertByAgeLessThan(int age);
	
	public ArrayList<Expert>findExpertByAgeGreaterThan(int age);
	
	public ArrayList<Expert>findExpertByLanguageId(List<String>langugeId);

	public ArrayList<Expert>findExpertByLanguageName(List<String>langugeName);
	
	public ArrayList<Expert>findExpertByPositionId(List<String>positionId);
	
	public ArrayList<Expert>findExpertByPositionName(List<String>positionName);
	
	public ArrayList<Expert>findExpertBetweenAge(int age1,int age2);

}
