package org.expertdatabase.repositories;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.expertdatabase.entities.Expert;
import org.expertdatabase.entities.ExpertAddress;
import org.expertdatabase.entities.ExpertContact;
import org.expertdatabase.entities.ExpertDocument;
import org.expertdatabase.entities.ExpertEducation;
import org.expertdatabase.entities.ExpertExperience;
import org.expertdatabase.entities.Language;
import org.expertdatabase.entities.Location;
import org.expertdatabase.entities.Position;
import org.expertdatabase.entities.Skill;
import org.expertdatabase.entities.temp.CounterExpert;
import org.springframework.stereotype.Repository;

@Repository
public interface FindExpertRepository {

	@Select("SELECT * FROM exp_expert_info WHERE expert_id=#{expertId} AND expert_state IS NOT FALSE ORDER BY expert_id")
	@Results(id="ResultSet",value={
			@Result(property="expert_id",column="expert_id"),
			
			@Result(property="location",column="location_id",
			one=@One(select="selectExpertLocation")),
			
			@Result(property="address",column="expert_id",
					one=@One(select="selectExpertAddress")),
			
			@Result(property="contacts",column="expert_id",
					many=@Many(select="selectExpertContact")),
			
			@Result(property="experiences",column="expert_id",
					many=@Many(select="selectExpertExperience")),
			
			@Result(property="educations",column="expert_id",
					many=@Many(select="selectExpertEducation")),
			
			@Result(property="documents",column="expert_id",
					many=@Many(select="selectExpertDocument")),
			
			@Result(property="skills",column="expert_id",
					many=@Many(select="selectExpertSkill")),
			
			@Result(property="positions",column="expert_id",
					many=@Many(select="selectExpertPosition")),
			
			@Result(property="languages",column="expert_id",
					many=@Many(select="selectExpertLanguage"))
			
	})
	public Expert findExpertById(@Param("expertId")int expertId);
	
	@Select("SELECT * FROM exp_expert_info WHERE expert_full_name=#{expertName} AND expert_state IS NOT FALSE ORDER BY expert_id")
	@ResultMap("ResultSet")
	public Expert findExpertByName(@Param("expertName")String expertName);

	@SelectProvider(type=org.expertdatabase.repositories.provider.ProviderSql.class,method="findExpertBySkillId")
	@ResultMap("ResultSet")
	public ArrayList<Expert>findExpertBySkillId(@Param("skillId")List<String> skillId);
	
	@SelectProvider(type=org.expertdatabase.repositories.provider.ProviderSql.class,method="countExpertBySkillId")
	public ArrayList<CounterExpert> countExpertBySkillId(@Param("skillId")List<String> skillId);

	@SelectProvider(type=org.expertdatabase.repositories.provider.ProviderSql.class,method="findExpertBySkillName")
	@ResultMap("ResultSet")
	public ArrayList<Expert>findExpertBySkillName(@Param("skillName")List<String> skillName);
	
	@SelectProvider(type=org.expertdatabase.repositories.provider.ProviderSql.class,method="countExpertBySkillName")
	public ArrayList<CounterExpert> countExpertBySkillName(@Param("skillName")List<String> skillName);
	
	@SelectProvider(type=org.expertdatabase.repositories.provider.ProviderSql.class,method="findExpertByLanguageId")
	@ResultMap("ResultSet")
	public ArrayList<Expert>findExpertByLanguageId(@Param("languageId")List<String>langugeId);
	
	@SelectProvider(type=org.expertdatabase.repositories.provider.ProviderSql.class,method="findExpertByLanguageName")
	@ResultMap("ResultSet")
	public ArrayList<Expert>findExpertByLanguageName(@Param("languageName")List<String>langugeName);
	
	@SelectProvider(type=org.expertdatabase.repositories.provider.ProviderSql.class,method="findExpertByPositionId")
	@ResultMap("ResultSet")
	public ArrayList<Expert>findExpertByPositionId(@Param("positionId")List<String>positionId);
	
	@SelectProvider(type=org.expertdatabase.repositories.provider.ProviderSql.class,method="findExpertByPositionName")
	@ResultMap("ResultSet")
	public ArrayList<Expert>findExpertByPositionName(@Param("positionName")List<String>positionName);
	
	@Select("SELECT * FROM (SELECT date_part('year', AGE(expert_date_of_birth)) AS expert_age,* FROM exp_expert_info) AS temps WHERE expert_age<#{age}")
	@ResultMap("ResultSet")
	public ArrayList<Expert>findExpertByAgeLessThan(int age);
	
	@Select("SELECT * FROM (SELECT date_part('year', AGE(expert_date_of_birth)) AS expert_age,* FROM exp_expert_info) AS temps WHERE expert_age>#{age}")
	@ResultMap("ResultSet")
	public ArrayList<Expert>findExpertByAgeGreaterThan(int age);
	
	@Select("SELECT * FROM (SELECT date_part('year', AGE(expert_date_of_birth)) AS expert_age,* FROM exp_expert_info) AS temps WHERE expert_age BETWEEN #{age1} AND #{age2}")
	@ResultMap("ResultSet")
	public ArrayList<Expert>findExpertBetweenAge(@Param("age1")int age1,@Param("age2")int age2);
	
	@Select("SELECT * FROM exp_expert_permanent_address WHERE expert_id=#{expert_id}")
	public ExpertAddress selectExpertAddress(int expertId);
	
	@Select("SELECT * FROM exp_expert_contact WHERE expert_id=#{expert_id}")
	public ArrayList<ExpertContact> selectExpertContact(int expertId);
	
	@Select("SELECT * FROM exp_expert_experience WHERE expert_id=#{expert_id}")
	public ArrayList<ExpertExperience> selectExpertExperience(int expertId);
	
	@Select("SELECT * FROM exp_expert_education WHERE expert_id=#{expert_id}")
	public ArrayList<ExpertEducation> selectExpertEducation(int expertId);
	
	@Select("SELECT * FROM exp_expert_document WHERE expert_id=#{expert_id}")
	public ArrayList<ExpertDocument> selectExpertDocument(int expertId);
	
	@Select("SELECT * FROM exp_locations WHERE location_id=#{location_id} AND location_state IS NOT FALSE")
	public Location selectExpertLocation(int locationId);
		
	
	
	final String SELECT_SKILL="SELECT exp_skills.skill_id,skill_status,level_status,level_range "
			+"FROM exp_expert_skill "
			+"INNER JOIN exp_skills ON exp_expert_skill.skill_id=exp_skills.skill_id "
			+"INNER JOIN exp_levels ON exp_expert_skill.level_id=exp_levels.level_id "
			+"WHERE exp_expert_skill.expert_id=#{expert_id}";
	@Select(SELECT_SKILL)	
	public ArrayList<Skill> selectExpertSkill(int expertId);
	
	
	final String SELECT_POSITION="SELECT exp_positions.position_id,position_status FROM exp_expert_position "
			+"INNER JOIN exp_positions "
			+"ON exp_expert_position.position_id=exp_positions.position_id "
			+"WHERE exp_expert_position.expert_id=#{expert_id};";
	@Select(SELECT_POSITION)
	public ArrayList<Position> selectExpertPosition(int expertId);
	
	final String SELECT_LANGUAGE="SELECT exp_languages.language_id,language_status,level_status "
			+"FROM exp_expert_language "
			+"INNER JOIN exp_languages " 
			+"ON exp_expert_language.language_id=exp_languages.language_id " 
			+"INNER JOIN exp_levels "
			+"ON exp_expert_language.level_id=exp_levels.level_id "
			+"WHERE exp_expert_language.expert_id=#{expert_id}";
	@Select(SELECT_LANGUAGE)
	public ArrayList<Language> selectExpertLanguage(int expertId);
	
}
