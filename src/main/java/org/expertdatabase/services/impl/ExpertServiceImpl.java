package org.expertdatabase.services.impl;

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
import org.expertdatabase.entities.SkillCategory;
import org.expertdatabase.entities.SkillCategory.TempCategory;
import org.expertdatabase.entities.temp.CountAll;
import org.expertdatabase.repositories.ExpertRepository;
import org.expertdatabase.services.ExpertService;
import org.expertdatabase.utilities.Pagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExpertServiceImpl implements ExpertService{

	@Autowired
	private ExpertRepository expertRepository;

	@Override
	public ArrayList<Expert> getAllExperts(Pagination pagination) {
		// TODO Auto-generated method stub
		return expertRepository.getAllExpertWithLimit(pagination);
	}
	
	@Override
	public int countExpert() {
		// TODO Auto-generated method stub
		return expertRepository.countExpert();
	}

	@Override
	public ArrayList<SkillCategory> selectAllSkillCategories() {
		// TODO Auto-generated method stub
		return expertRepository.selectAllSkillCategories();
	}

	@Override
	public ArrayList<Position> selectAllPositions() {
		// TODO Auto-generated method stub
		return expertRepository.selectAllPositions();
	}

	@Override
	public ArrayList<TempLanguage> selectAllLanguages() {
		
		return expertRepository.selectAllLanguages();
	}

	@Override
	public ArrayList<Location> selectAllLocations() {
		// TODO Auto-generated method stub
		return expertRepository.selectAllLocations();
	}

	@Override
	public ArrayList<TempCategory> selectAllCategories() {
		// TODO Auto-generated method stub
		return expertRepository.selectAllCategories();
	}

	@Override
	public ArrayList<Level> selectAllLevels() {
		// TODO Auto-generated method stub
		return expertRepository.selectAllLevels();
	}

	@Override
	public ArrayList<TempInnerSkill> selectSkillByCategoryId(int categoryId) {
		if(categoryId>0)
			return expertRepository.selectSkillByCategoryId(categoryId);
		else
			return null;
	}

	@Override
	public Location selectExpertLocation(int locationId) {
		if(locationId>0)
			return expertRepository.selectExpertLocation(locationId);
		else
			return null;
	}

	@Override
	public ExpertAddress selectExpertAddress(int expertId) {
		if(expertId>0)
			return expertRepository.selectExpertAddress(expertId);
		else
			return null;
	}

	@Override
	public ArrayList<ExpertContact> selectExpertContact(int expertId) {
		if(expertId>0)
			return expertRepository.selectExpertContact(expertId);
		else
			return null;
	}

	@Override
	public ArrayList<ExpertExperience> selectExpertExperience(int expertId) {
		if(expertId>0)
			return expertRepository.selectExpertExperience(expertId);
		else
			return null;
	}

	@Override
	public ArrayList<ExpertEducation> selectExpertEducation(int expertId) {
		if(expertId>0)
			return expertRepository.selectExpertEducation(expertId);
		else
			return null;
	}

	@Override
	public ArrayList<ExpertDocument> selectExpertDocument(int expertId) {
		if(expertId>0)
			return expertRepository.selectExpertDocument(expertId);
		else
			return null;
	}

	@Override
	public ArrayList<Skill> selectExpertSkill(int expertId) {
		if(expertId>0)
			return expertRepository.selectExpertSkill(expertId);
		else
			return null;
	}

	@Override
	public ArrayList<Position> selectExpertPosition(int expertId) {
		if(expertId>0)
			return expertRepository.selectExpertPosition(expertId);
		else
			return null;
	}

	@Override
	public ArrayList<Language> selectExpertLanguage(int expertId) {
		if(expertId>0)
			return expertRepository.selectExpertLanguage(expertId);
		else
			return null;
	}

	@Override
	public ArrayList<TempInnerSkill> selectAllSkills() {
		return expertRepository.selectAllSkills();
	}

	@Override
	public ArrayList<Expert> getAllExperts() {
		// TODO Auto-generated method stub
		return expertRepository.getAllExperts();
	}

	@Override
	public Location selectLocationByExpertId(int expertId) {
		if(expertId>0)
			return expertRepository.selectLocationByExpertId(expertId);
		else
			return null;
	}

	@Override
	public CountAll countAll() {
		CountAll obj=new CountAll();
		obj.setCountExpert(expertRepository.countExperts());
		obj.setCountSkill(expertRepository.countSkill());
		obj.setCountLanguage(expertRepository.countLanguage());
		obj.setCountLocation(expertRepository.countLocation());
		obj.setCountPosition(expertRepository.countPosition());
		obj.setCountCategory(expertRepository.countCategory());
		return obj;
	}

	@Override
	public String findDocumentURLById(int documentId) {
		
		if(documentId>0)
			return expertRepository.findDocumentURLById(documentId);
		else
			return "";
	}

	@Override
	public String findProfileImageById(int expertId) {
		
		if(expertId>0)
			return expertRepository.findProfileImageById(expertId);
		else
			return "";
	}

}
