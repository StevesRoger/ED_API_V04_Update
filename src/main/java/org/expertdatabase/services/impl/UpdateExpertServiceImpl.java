package org.expertdatabase.services.impl;

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
import org.expertdatabase.repositories.UpdateExpertRepository;
import org.expertdatabase.services.UpdateExpertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdateExpertServiceImpl implements UpdateExpertService{

	@Autowired
	private UpdateExpertRepository updateExpertRepositry;

	@Override
	public boolean updateLanguage(UpdateLanguage language) {
		if(language!=null)
			return updateExpertRepositry.updateLanguage(language);
		else
			return false;
	}

	@Override
	public boolean updateLocation(UpdateLocation location) {
		if(location!=null)
			return updateExpertRepositry.updateLocation(location);
		else
			return false;
	}

	@Override
	public boolean updatePosition(UpdatePosition position) {
		if(position!=null)
			return updateExpertRepositry.updatePosition(position);
		else
			return false;
	}

	@Override
	public boolean updateSkill(UpdateSkill skill) {
		if(skill!=null)
			return updateExpertRepositry.updateSkill(skill);
		else
			return false;
	}

	@Override
	public boolean updateSkillCategory(UpdateCategory category) {
		if(category!=null)
			return updateExpertRepositry.updateSkillCategory(category);
		else
			return false;
	}

	@Override
	public boolean updateLevel(UpdateLevel level) {
		if(level!=null)
			return updateExpertRepositry.updateLevel(level);
		else
			return false;
	}

	@Override
	public boolean updateExpert(int expertId,UpdateExpert expert) {
		boolean temp=false;
		if(expert!=null){
			if(updateExpertRepositry.updateExpert(expertId,expert)){
				temp=true;
				updateExpertAddress(expertId, expert.getAddress());
				updateExpertContacts(expertId, expert.getContacts());
				updateExpertEducations(expertId, expert.getEducations());
				updateExpertDocuments(expertId, expert.getDocuments());
				updateExpertExperiences(expertId, expert.getExperiences());
				updateExpertLanguages(expertId, expert.getLanguages());
				updateExpertSkills(expertId, expert.getSkills());
				updateExpertPositions(expertId,expert.getPositions());
			}
			
		}
		return temp;
	}

	@Override
	public boolean updateExpertAddress(int expertId, UpdateExpertAddress address) {
	
		if(expertId>0&&address!=null)
			return updateExpertRepositry.updateExpertAddress(expertId, address);
		else
			return false;
	}

	@Override
	public boolean updateExpertContacts(int expertId, List<UpdateExpertContact> contacts) {
	
		if(expertId>0&&contacts!=null)
			return updateExpertRepositry.updateExpertContacts(expertId, contacts);
		else
			return false;
	}

	@Override
	public boolean updateExpertEducations(int expertId, List<UpdateExpertEducation> educations) {
		
		if(expertId>0&&educations!=null)
			return updateExpertRepositry.updateExpertEducations(expertId, educations);
		else
			return false;
	}

	@Override
	public boolean updateExpertDocuments(int expertId, List<UpdateExpertDocument> documents) {
	
		if(expertId>0&&documents!=null)
			return updateExpertRepositry.updateExpertDocuments(expertId, documents);
		else
			return false;
	}

	@Override
	public boolean updateExpertExperiences(int expertId, List<UpdateExpertExperience> experiences) {
		
		if(expertId>0&&experiences!=null)
			return updateExpertRepositry.updateExpertExperiences(expertId, experiences);
		else
			return false;
	}

	@Override
	public boolean updateExpertLanguages(int expertId, List<UpdateExpertLanguage> languages) {

		if(expertId>0&&languages!=null)
			return updateExpertRepositry.updateExpertLanguages(expertId, languages);
		else
			return false;
	}

	@Override
	public boolean updateExpertSkills(int expertId, List<UpdateExpertSkill> skills) {

		if(expertId>0&&skills!=null)
			return updateExpertRepositry.updateExpertSkills(expertId, skills);
		else
			return false;
	}

	@Override
	public boolean updateExpertPositions(int expertId, List<UpdateExpertPosition> positions) {

		if(expertId>0&&positions!=null)
			return updateExpertRepositry.updateExpertPositions(expertId, positions);
		else
			return false;
	}

	@Override
	public boolean changeLocationState(int locationId,boolean state) {
		System.out.println(locationId+""+state);
		if(locationId>0)
			return updateExpertRepositry.changeLocationState(locationId,state);
		else
			return false;
	}

}
