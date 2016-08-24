package org.expertdatabase.repositories;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.expertdatabase.entities.input.AddCategory.UpdateCategory;
import org.expertdatabase.entities.input.AddLanguage.UpdateLanguage;
import org.expertdatabase.entities.input.AddLevel.UpdateLevel;
import org.expertdatabase.entities.input.AddLocation.UpdateLocation;
import org.expertdatabase.entities.input.AddPosition.UpdatePosition;
import org.expertdatabase.entities.input.AddSkill.UpdateSkill;
import org.expertdatabase.entities.update.UpdateExpert;
import org.expertdatabase.entities.update.UpdateExpert.UpdateExpertLanguage;
import org.expertdatabase.entities.update.UpdateExpert.UpdateExpertSkill;
import org.expertdatabase.entities.update.UpdateExpert.UpdateExpertPosition;
import org.expertdatabase.entities.update.UpdateExpertAddress;
import org.expertdatabase.entities.update.UpdateExpertContact;
import org.expertdatabase.entities.update.UpdateExpertDocument;
import org.expertdatabase.entities.update.UpdateExpertEducation;
import org.expertdatabase.entities.update.UpdateExpertExperience;
import org.springframework.stereotype.Repository;

@Repository
public interface UpdateExpertRepository {

	public boolean updateLanguage(UpdateLanguage language);
	
	public boolean updateLocation(UpdateLocation location);
	
	public boolean updatePosition(UpdatePosition position);
	
	public boolean updateSkill(UpdateSkill skill);
	
	public boolean updateSkillCategory(UpdateCategory categoryId);
	
	public boolean updateLevel(UpdateLevel level);
	
	public boolean updateExpert(@Param("expertId")int expertId,@Param("expert")UpdateExpert expert);
	
	public boolean updateExpertAddress(@Param("expertId")int expertId,@Param("address")UpdateExpertAddress address);

	public boolean updateExpertContacts(@Param("expertId")int expertId,@Param("contacts")List<UpdateExpertContact>contacts);
	
	public boolean updateExpertEducations(@Param("expertId")int expertId,@Param("educations")List<UpdateExpertEducation> educations);
	
	public boolean updateExpertDocuments(@Param("expertId")int expertId,@Param("documents")List<UpdateExpertDocument>documents);
	
	public boolean updateExpertExperiences(@Param("expertId")int expertId,@Param("experiences")List<UpdateExpertExperience>experiences);
	
	public boolean updateExpertLanguages(@Param("expertId")int expertId,@Param("languages")List<UpdateExpertLanguage>languages);
	
	public boolean updateExpertSkills(@Param("expertId")int expertId,@Param("skills")List<UpdateExpertSkill>skills);
	
	public boolean updateExpertPositions(@Param("expertId")int expertId,@Param("positions")List<UpdateExpertPosition>positions);
	
	public boolean changeLocationState(@Param("locationId")int locationId,@Param("state")boolean state);
}
