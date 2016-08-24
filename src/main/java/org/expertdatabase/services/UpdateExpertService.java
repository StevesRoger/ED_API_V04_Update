package org.expertdatabase.services;

import java.util.List;
import org.expertdatabase.entities.input.AddCategory.UpdateCategory;
import org.expertdatabase.entities.input.AddLanguage.UpdateLanguage;
import org.expertdatabase.entities.input.AddLevel.UpdateLevel;
import org.expertdatabase.entities.input.AddLocation.UpdateLocation;
import org.expertdatabase.entities.input.AddPosition.UpdatePosition;
import org.expertdatabase.entities.input.AddSkill.UpdateSkill;
import org.expertdatabase.entities.update.UpdateExpert;
import org.expertdatabase.entities.update.UpdateExpert.UpdateExpertLanguage;
import org.expertdatabase.entities.update.UpdateExpert.UpdateExpertPosition;
import org.expertdatabase.entities.update.UpdateExpert.UpdateExpertSkill;
import org.expertdatabase.entities.update.UpdateExpertAddress;
import org.expertdatabase.entities.update.UpdateExpertContact;
import org.expertdatabase.entities.update.UpdateExpertDocument;
import org.expertdatabase.entities.update.UpdateExpertEducation;
import org.expertdatabase.entities.update.UpdateExpertExperience;

public interface UpdateExpertService {

	public boolean updateLanguage(UpdateLanguage language);
	
	public boolean updateLocation(UpdateLocation location);
	
	public boolean updatePosition(UpdatePosition position);
	
	public boolean updateSkill(UpdateSkill skill);
	
	public boolean updateSkillCategory(UpdateCategory category);
	
	public boolean updateLevel(UpdateLevel level);
	
	public boolean updateExpert(int expertId,UpdateExpert expert);
	
	public boolean updateExpertAddress(int expertId,UpdateExpertAddress address);

	public boolean updateExpertContacts(int expertId,List<UpdateExpertContact>contacts);
	
	public boolean updateExpertEducations(int expertId,List<UpdateExpertEducation> educations);
	
	public boolean updateExpertDocuments(int expertId,List<UpdateExpertDocument>documents);
	
	public boolean updateExpertExperiences(int expertId,List<UpdateExpertExperience>experiences);
	
	public boolean updateExpertLanguages(int expertId,List<UpdateExpertLanguage>languages);
	
	public boolean updateExpertSkills(int expertId,List<UpdateExpertSkill>skills);
	
	public boolean updateExpertPositions(int expertId,List<UpdateExpertPosition>positions);
		
	public boolean changeLocationState(int locationId,boolean state);
}
