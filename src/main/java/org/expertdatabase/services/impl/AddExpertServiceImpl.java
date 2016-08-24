package org.expertdatabase.services.impl;

import java.util.List;
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
import org.expertdatabase.repositories.AddExpertRepository;
import org.expertdatabase.services.AddExpertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddExpertServiceImpl implements AddExpertService{

	@Autowired
	private AddExpertRepository addExpertRepository;
	
	@Override
	public boolean addLanguage(AddLanguage language) {
		boolean temp=false;
		if(language!=null)
			temp=addExpertRepository.addLanguage(language);
		return temp;
	}

	@Override
	public boolean addPosition(AddPosition position) {
		boolean temp=false;
		if(position!=null)
			temp=addExpertRepository.addPosition(position);
		return temp;
	}

	@Override
	public boolean addSkill(AddSkill skill) {
		boolean temp=false;
		if(skill!=null)
			temp=addExpertRepository.addSkill(skill);
		return temp;
	}

	@Override
	public boolean addSkillCategory(AddCategory category) {
		boolean temp=false;
		if(category!=null)
			temp=addExpertRepository.addSkillCategory(category);
		return temp;
	}

	@Override
	public boolean addExpert(AddExpert expert) {
		boolean temp=false;
		if(expert!=null){
		temp=addExpertRepository.addExpert(expert);
		int expertId=expert.getExpertId();
		if(temp){
			addExpertAddress(expertId, expert.getAddress());
			addExpertContacts(expertId, expert.getContacts());
			addExpertEducations(expertId, expert.getEducations());
			addExpertDocuments(expertId, expert.getDocuments());
			addExpertExperiences(expertId, expert.getExperiences());
			addExpertLanguages(expertId, expert.getLanguages());
			addExpertSkills(expertId, expert.getSkills());
			addExpertPositions(expertId, expert.getPositionIds());
			}
		}
		return temp;
	}

	@Override
	public boolean addLocation(AddLocation location) {
		boolean temp=false;
		if(location!=null)
			temp=addExpertRepository.addLocation(location);
		return temp;
	}

	@Override
	public boolean addLevel(AddLevel level) {
		boolean temp=false;
		if(level!=null)
			temp=addExpertRepository.addLevel(level);
		return temp;
	}

	@Override
	public boolean addExpertAddress(int expertId, AddExpertAddress address) {
		boolean temp=false;
		if(expertId>0&&address!=null)
			temp=addExpertRepository.addExpertAddress(expertId, address);

		return temp;
	}

	@Override
	public boolean addExpertContacts(int expertId, List<AddExpertContact> contacts) {
		boolean temp=false;
		if(expertId>0&&contacts!=null){
			if(!contacts.isEmpty())
				temp=addExpertRepository.addExpertContacts(expertId, contacts);
		}
		return temp;
	}

	@Override
	public boolean addExpertEducations(int expertId, List<AddExpertEducation> educations) {
		boolean temp=false;
		if(expertId>0&&educations!=null){
			if(!educations.isEmpty())
				temp=addExpertRepository.addExpertEducations(expertId, educations);
		}
		return temp;
	}

	@Override
	public boolean addExpertDocuments(int expertId, List<AddExpertDocument> documents) {
		boolean temp=false;
		if(expertId>0&&documents!=null){
			if(!documents.isEmpty())
				temp=addExpertRepository.addExpertDocuments(expertId, documents);
		}
		return temp;
	}

	@Override
	public boolean addExpertExperiences(int expertId, List<AddExpertExperience> experiences) {
		boolean temp=false;
		if(expertId>0&&experiences!=null){
			if(!experiences.isEmpty())
				temp=addExpertRepository.addExpertExperiences(expertId, experiences);
		}
		return temp;
	}

	@Override
	public boolean addExpertLanguages(int expertId, List<AddExpertLanguage> languages) {
		boolean temp=false;
		if(expertId>0&&languages!=null){
			if(!languages.isEmpty())
				temp=addExpertRepository.addExpertLanguages(expertId, languages);
		}
		return temp;
	}

	@Override
	public boolean addExpertSkills(int expertId, List<AddExpertSkill> skills) {
		boolean temp=false;
		if(expertId>0&&skills!=null){
			if(!skills.isEmpty())
				temp=addExpertRepository.addExpertSkills(expertId, skills);
		}
		return temp;
	}

	@Override
	public boolean addExpertPositions(int expertId, List<Integer> positionIds) {
		boolean temp=false;
		if(expertId>0&&positionIds!=null){
			if(!positionIds.isEmpty())
				temp=addExpertRepository.addExpertPositions(expertId, positionIds);
		}
		return temp;
	}


}
