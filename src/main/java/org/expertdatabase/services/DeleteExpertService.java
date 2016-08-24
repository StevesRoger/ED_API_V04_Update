package org.expertdatabase.services;

import org.apache.ibatis.annotations.Param;

public interface DeleteExpertService {

	public boolean deleteLanguage(int languageId);
	
	public boolean deletePosition(int positionId);
	
	public boolean deleteSkill(int skillId);
	
	public boolean deleteSkillCategory(int categoryId);
	
	public boolean deleteLocation(int locationId);
	
	public boolean deleteLevel(int levelId);
	
	public boolean deleteExpert(int expertId);
	
	public boolean deleteExpertAddress(int expertId,int addressId);

	public boolean deleteExpertContact(int expertId,int contactId);
	
	public boolean deleteExpertEducation(int expertId,int educationId);
	
	public boolean deleteExpertDocument(int expertId,int documentId);
	
	public boolean deleteExpertExperience(int expertId,int experienceId);
	
	public boolean deleteExpertLanguage(int expertId,int languageId);
	
	public boolean deleteExpertSkill(int expertId,int skillId);
	
	public boolean deleteExpertPosition(int expertId,int positionId);
}
