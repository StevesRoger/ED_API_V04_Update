package org.expertdatabase.repositories;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.expertdatabase.entities.input.AddCategory;
import org.expertdatabase.entities.input.AddExpert;
import org.expertdatabase.entities.input.AddExpert.AddExpertLanguage;
import org.expertdatabase.entities.input.AddExpert.AddExpertSkill;
import org.expertdatabase.entities.input.AddExpertAddress;
import org.expertdatabase.entities.input.AddExpertContact;
import org.expertdatabase.entities.input.AddExpertDocument;
import org.expertdatabase.entities.input.AddExpertEducation;
import org.expertdatabase.entities.input.AddExpertExperience;
import org.expertdatabase.entities.input.AddLanguage;
import org.expertdatabase.entities.input.AddLevel;
import org.expertdatabase.entities.input.AddLocation;
import org.expertdatabase.entities.input.AddPosition;
import org.expertdatabase.entities.input.AddSkill;
import org.springframework.stereotype.Repository;

@Repository
public interface AddExpertRepository {

	public boolean addLanguage(AddLanguage language);
	
	public boolean addPosition(AddPosition position);
	
	public boolean addLocation(AddLocation location);
	
	public boolean addLevel(AddLevel level);
	
	public boolean addSkill(AddSkill skill);
	
	public boolean addSkillCategory(AddCategory category);
	
	public boolean addExpert(AddExpert expert);
	
	public boolean addExpertAddress(@Param("expertId")int expertId,@Param("address")AddExpertAddress address);

	public boolean addExpertContacts(@Param("expertId")int expertId,@Param("contacts")List<AddExpertContact>contacts);
	
	public boolean addExpertEducations(@Param("expertId")int expertId,@Param("educations")List<AddExpertEducation> educations);
	
	public boolean addExpertDocuments(@Param("expertId")int expertId,@Param("documents")List<AddExpertDocument>documents);
	
	public boolean addExpertExperiences(@Param("expertId")int expertId,@Param("experiences")List<AddExpertExperience>experiences);
	
	public boolean addExpertLanguages(@Param("expertId")int expertId,@Param("languages")List<AddExpertLanguage>languages);
	
	public boolean addExpertSkills(@Param("expertId")int expertId,@Param("skills")List<AddExpertSkill>skills);
	
	public boolean addExpertPositions(@Param("expertId")int expertId,@Param("positionIds")List<Integer>positionIds);
	
}
