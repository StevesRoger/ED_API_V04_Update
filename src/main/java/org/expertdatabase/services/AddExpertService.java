package org.expertdatabase.services;

import java.util.List;

import org.expertdatabase.entities.input.AddCategory;
import org.expertdatabase.entities.input.AddExpert;
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
import org.expertdatabase.entities.input.AddExpert.AddExpertLanguage;
import org.expertdatabase.entities.input.AddExpert.AddExpertSkill;

public interface AddExpertService {

	public boolean addLanguage(AddLanguage language);
	
	public boolean addPosition(AddPosition position);
	
	public boolean addSkill(AddSkill skill);
	
	public boolean addSkillCategory(AddCategory category);
	
	public boolean addLocation(AddLocation location);
	
	public boolean addLevel(AddLevel level);
	
	public boolean addExpert(AddExpert expert);
	
	public boolean addExpertAddress(int expertId,AddExpertAddress address);

	public boolean addExpertContacts(int expertId,List<AddExpertContact>contacts);
	
	public boolean addExpertEducations(int expertId,List<AddExpertEducation> educations);
	
	public boolean addExpertDocuments(int expertId,List<AddExpertDocument>documents);
	
	public boolean addExpertExperiences(int expertId,List<AddExpertExperience>experiences);
	
	public boolean addExpertLanguages(int expertId,List<AddExpertLanguage>languages);
	
	public boolean addExpertSkills(int expertId,List<AddExpertSkill>skills);
	
	public boolean addExpertPositions(int expertId,List<Integer>positionIds);
}
