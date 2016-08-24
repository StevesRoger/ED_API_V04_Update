package org.expertdatabase.repositories;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.expertdatabase.entities.update.UpdateExpertAddress;
import org.expertdatabase.entities.update.UpdateExpertContact;
import org.expertdatabase.entities.update.UpdateExpertDocument;
import org.expertdatabase.entities.update.UpdateExpertEducation;
import org.expertdatabase.entities.update.UpdateExpertExperience;
import org.expertdatabase.entities.update.UpdateExpert.UpdateExpertLanguage;
import org.expertdatabase.entities.update.UpdateExpert.UpdateExpertPosition;
import org.expertdatabase.entities.update.UpdateExpert.UpdateExpertSkill;
import org.springframework.stereotype.Repository;

@Repository
public interface DeleteExpertRepository {

	public boolean deleteLanguage(@Param("languageId")int languageId);
	
	public boolean deletePosition(@Param("positionId")int positionId);
	
	public boolean deleteSkill(@Param("skillId")int skillId);
	
	public boolean deleteSkillCategory(@Param("categoryId")int categoryId);
	
	public boolean deleteLocation(@Param("locationId")int locationId);
	
	public boolean changeStateLocation(@Param("locationId")int locationId);
	
	public boolean deleteLevel(@Param("levelId")int levelId);
	
	public boolean deleteExpert(@Param("expertId")int expertId);
	
	public boolean deleteExpertAddress(@Param("expertId")int expertId,@Param("addressId")int addressId);

	public boolean deleteExpertContact(@Param("expertId")int expertId,@Param("contactId")int contactId);
	
	public boolean deleteExpertEducation(@Param("expertId")int expertId,@Param("educationId")int educationId);
	
	public boolean deleteExpertDocument(@Param("expertId")int expertId,@Param("documentId")int documentId);
	
	public boolean deleteExpertExperience(@Param("expertId")int expertId,@Param("experienceId")int experienceId);
	
	public boolean deleteExpertLanguage(@Param("expertId")int expertId,@Param("languageId")int languageId);
	
	public boolean deleteExpertSkill(@Param("expertId")int expertId,@Param("skillId")int skillId);
	
	public boolean deleteExpertPosition(@Param("expertId")int expertId,@Param("positionId")int positionId);
	
}
