package org.expertdatabase.services.impl;

import org.expertdatabase.repositories.DeleteExpertRepository;
import org.expertdatabase.services.DeleteExpertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteExpertServiceImpl implements DeleteExpertService {
	
	@Autowired
	private DeleteExpertRepository deleteExpertRepository;
	
	@Override
	public boolean deleteLanguage(int languageId) {
	
		if(languageId>0)
			return deleteExpertRepository.deleteLanguage(languageId);
		else
			return false;
	}

	@Override
	public boolean deletePosition(int positionId) {

		if(positionId>0)
			return deleteExpertRepository.deletePosition(positionId);
		else 
			return false;
	}

	@Override
	public boolean deleteSkill(int skillId) {

		if(skillId>0)
			return deleteExpertRepository.deleteSkill(skillId);
		else
			return false;
	}

	@Override
	public boolean deleteSkillCategory(int categoryId) {
	
		if(categoryId>0)
			return deleteExpertRepository.deleteSkillCategory(categoryId);
		else
			return false;
	}

	@Override
	public boolean deleteLocation(int locationId) {
		boolean temp=false;
		if(locationId>0){
			temp=deleteExpertRepository.deleteLocation(locationId);
			if(!temp)
				temp=deleteExpertRepository.changeStateLocation(locationId);
		}
		return temp;
	}

	@Override
	public boolean deleteExpert(int expertId) {
	
		if(expertId>0)
			return deleteExpertRepository.deleteExpert(expertId);
		else
			return false;
	}

	@Override
	public boolean deleteLevel(int levelId) {
		
		if(levelId>0)
			return deleteExpertRepository.deleteLevel(levelId);
		else
			return false;
	}

	@Override
	public boolean deleteExpertAddress(int expertId, int addressId) {
		
		if(expertId>0&&addressId>0)
			return deleteExpertRepository.deleteExpertAddress(expertId, addressId);
		else
			return false;
	}

	@Override
	public boolean deleteExpertContact(int expertId, int contactId) {
		
		if(expertId>0&&contactId>0)
			return deleteExpertRepository.deleteExpertContact(expertId, contactId);
		else
			return false;
	}

	@Override
	public boolean deleteExpertEducation(int expertId, int educationId) {
		
		if(expertId>0&&educationId>0)
			return deleteExpertRepository.deleteExpertEducation(expertId, educationId);
		else
			return false;
	}

	@Override
	public boolean deleteExpertDocument(int expertId, int documentId) {
		
		if(expertId>0&&documentId>0)
			return deleteExpertRepository.deleteExpertDocument(expertId, documentId);
		else
			return false;
	}

	@Override
	public boolean deleteExpertExperience(int expertId, int experienceId) {
		
		if(expertId>0&&experienceId>0)
			return deleteExpertRepository.deleteExpertExperience(expertId, experienceId);
		else
			return false;
	}

	@Override
	public boolean deleteExpertLanguage(int expertId, int languageId) {
		
		if(expertId>0&&languageId>0)
			return deleteExpertRepository.deleteExpertLanguage(expertId, languageId);
		else
			return false;
	}

	@Override
	public boolean deleteExpertSkill(int expertId, int skillId) {

		if(expertId>0&&skillId>0)
			return deleteExpertRepository.deleteExpertSkill(expertId, skillId);
		else
			return false;
	}

	@Override
	public boolean deleteExpertPosition(int expertId, int positionId) {

		if(expertId>0&&positionId>0)
			return deleteExpertRepository.deleteExpertPosition(expertId, positionId);
		else
			return false;
	}

}
