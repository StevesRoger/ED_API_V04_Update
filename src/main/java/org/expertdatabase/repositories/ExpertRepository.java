package org.expertdatabase.repositories;

import java.util.ArrayList;
import org.expertdatabase.entities.Expert;
import org.expertdatabase.entities.ExpertAddress;
import org.expertdatabase.entities.ExpertContact;
import org.expertdatabase.entities.ExpertDocument;
import org.expertdatabase.entities.ExpertEducation;
import org.expertdatabase.entities.ExpertExperience;
import org.expertdatabase.entities.Language;
import org.expertdatabase.entities.Language.TempLanguage;
import org.expertdatabase.entities.Level;
import org.expertdatabase.entities.Location;
import org.expertdatabase.entities.Position;
import org.expertdatabase.entities.Skill;
import org.expertdatabase.entities.Skill.TempInnerSkill;
import org.expertdatabase.entities.Skill.TempSkill;
import org.expertdatabase.entities.SkillCategory;
import org.expertdatabase.entities.SkillCategory.TempCategory;
import org.expertdatabase.utilities.Pagination;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpertRepository {
	
	public ArrayList<Expert>getAllExperts();
	
	public ArrayList<Expert>getAllExpertWithLimit(Pagination pagination);
	
	public int countExpert();

	public Location selectExpertLocation(int locationId);
	
	public Location selectLocationByExpertId(int expertId);
	
	public ExpertAddress selectExpertAddress(int expertId);
	
	public ArrayList<ExpertContact> selectExpertContact(int expertId);

	public ArrayList<ExpertExperience> selectExpertExperience(int expertId);
	
	public ArrayList<ExpertEducation> selectExpertEducation(int expertId);
	
	public ArrayList<ExpertDocument> selectExpertDocument(int expertId);
	
	public ArrayList<Skill> selectExpertSkill(int expertId);
		
	public ArrayList<Position> selectExpertPosition(int expertId);
	
	public ArrayList<Language> selectExpertLanguage(int expertId);
	
	public ArrayList<Level>selectAllLevels();
	
	public ArrayList<Location>selectAllLocations();
	
	public ArrayList<Position>selectAllPositions();

	public ArrayList<SkillCategory>selectAllSkillCategories();

	public ArrayList<TempSkill>selectSkillByCategoryIdCount(int categoryId);
	
	public ArrayList<TempLanguage>selectAllLanguages();
	
	public ArrayList<TempCategory>selectAllCategories();
	
	public ArrayList<TempInnerSkill>selectSkillByCategoryId(int categoryId);
	
	public ArrayList<TempInnerSkill>selectAllSkills();
	
	public int countExperts();
	
	public int countSkill();
	
	public int countLanguage();
	
	public int countCategory();
	
	public int countPosition();
	
	public int countLocation();
	
	public String findDocumentURLById(int documentId);
	
	public String findProfileImageById(int expertId);
	
}
