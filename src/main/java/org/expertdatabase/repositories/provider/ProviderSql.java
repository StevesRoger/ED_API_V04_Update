package org.expertdatabase.repositories.provider;

import java.util.List;
import java.util.Map;

public class ProviderSql {

	private static StringBuilder sb=null;
	private static List<String>list=null;
	private static String str=null;
	
	public static String findExpertBySkillId(Map<String,Object> map){
		list=(List<String>) map.get("skillId");
		if(!list.isEmpty()){
			str="SELECT exp_expert_info.* "
					   +"FROM exp_expert_info "
					   +"INNER JOIN exp_expert_skill "
					   +"ON exp_expert_skill.expert_id=exp_expert_info.expert_id "
					   +"INNER JOIN exp_skills "
					   +"ON exp_expert_skill.skill_id=exp_skills.skill_id "
					   +"WHERE exp_expert_skill.skill_id IN(";	
			sb=new StringBuilder(str);
			for(String val:list){
				sb.append(val).append(',');
			}
			sb.deleteCharAt(sb.length()-1);
			sb.append(") AND expert_state IS NOT FALSE");
		}
		return sb.toString();
	}

	public static String countExpertBySkillId(Map<String,Object>map){
		list=(List<String>) map.get("skillId");
		if(!list.isEmpty()){
			StringBuilder temp= new StringBuilder("WHERE exp_skills.skill_id IN(");
			for(String val:list)
				temp.append(val).append(',');
			temp.deleteCharAt(temp.length()-1);
			temp.append(") AND expert_state IS NOT FALSE)");
			str="SELECT category_status,skill_status,COUNT(category_id) "
			+"FROM "
				+"(SELECT category_status,exp_skills.category_id,skill_status "
				+"FROM exp_expert_info "
				+"INNER JOIN exp_expert_skill "
				+"ON exp_expert_skill.expert_id=exp_expert_info.expert_id "
				+"INNER JOIN exp_skills "
				+"ON exp_expert_skill.skill_id=exp_skills.skill_id "
				+"INNER JOIN exp_skill_category "
				+"ON exp_skill_category.category_id=exp_skills.category_id "
				+temp+"AS temps "
				+"GROUP BY (temps.category_status,skill_status)";
			sb=new StringBuilder(str);
		}
		return sb.toString();
	}
	
	public String countExpertBySkillName(Map<String,Object>map){
		list=(List<String>) map.get("skillName");
		if(!list.isEmpty()){
			StringBuilder temp= new StringBuilder("WHERE skill_status IN(");
			for(String val:list)
				temp.append("'"+val+"'").append(',');
			temp.deleteCharAt(temp.length()-1);
			temp.append(") AND expert_state IS NOT FALSE)");
			str="SELECT category_status,skill_status,COUNT(category_id) "
					+"FROM "
						+"(SELECT category_status,exp_skills.category_id,skill_status "
						+"FROM exp_expert_info "
						+"INNER JOIN exp_expert_skill "
						+"ON exp_expert_skill.expert_id=exp_expert_info.expert_id "
						+"INNER JOIN exp_skills "
						+"ON exp_expert_skill.skill_id=exp_skills.skill_id "
						+"INNER JOIN exp_skill_category "
						+"ON exp_skill_category.category_id=exp_skills.category_id "
						+temp+"AS temps "
						+"GROUP BY (temps.category_status,skill_status)";
			sb=new StringBuilder(str);
		}
		return sb.toString();
	}
	
	public String findExpertBySkillName(Map<String,Object> map){
		list=(List<String>) map.get("skillName");
		if(!list.isEmpty()){
			str="SELECT exp_expert_info.* "
					   +"FROM exp_expert_info "
					   +"INNER JOIN exp_expert_skill "
					   +"ON exp_expert_skill.expert_id=exp_expert_info.expert_id "
					   +"INNER JOIN exp_skills "
					   +"ON exp_expert_skill.skill_id=exp_skills.skill_id "
					   +"WHERE skill_status IN(";	
			sb=new StringBuilder(str);
			for(String val:list){
				sb.append("'"+val+"'").append(',');
			}
			sb.deleteCharAt(sb.length()-1);
			sb.append(") AND expert_state IS NOT FALSE");
		}
		return sb.toString();
	}		

	public String findExpertByLanguageId(Map<String,Object>map){
		list=(List<String>) map.get("languageId");
		if(!list.isEmpty()){
			str="SELECT exp_expert_info.* "
					+"FROM exp_expert_info "
					+"INNER JOIN exp_expert_language "
					+"ON exp_expert_info.expert_id=exp_expert_language.expert_id "
					+"WHERE language_id IN(";
			sb=new StringBuilder(str);
			for(String val:list)
				sb.append(val).append(',');
			sb.deleteCharAt(sb.length()-1);
			sb.append(") AND expert_state IS NOT FALSE");
		}
		return sb.toString();
	}
	
	public String findExpertByLanguageName(Map<String,Object>map){
		list=(List<String>) map.get("languageName");
		if(!list.isEmpty()){
			str="SELECT exp_expert_info.* "
					+"FROM exp_expert_info "
					+"INNER JOIN exp_expert_language "
					+"ON exp_expert_info.expert_id=exp_expert_language.expert_id "
					+"INNER JOIN exp_languages "
					+"ON exp_languages.language_id=exp_expert_language.language_id "
					+"WHERE language_status IN(";
			sb=new StringBuilder(str);
			for(String val:list)
				sb.append("'"+val+"'").append(',');
			sb.deleteCharAt(sb.length()-1);
			sb.append(") AND expert_state IS NOT FALSE");
		}
		return sb.toString();
	}
	
	public String findExpertByPositionId(Map<String,Object>map){
		list=(List<String>) map.get("positionId");
		if(!list.isEmpty()){
			str="SELECT exp_expert_info.* "
					+"FROM exp_expert_info "
					+"INNER JOIN exp_expert_position "
					+"ON exp_expert_info.expert_id=exp_expert_position.expert_id "
					+"WHERE position_id IN(";
			sb=new StringBuilder(str);
			for(String val:list)
				sb.append(val).append(',');
			sb.deleteCharAt(sb.length()-1);
			sb.append(") AND expert_state IS NOT FALSE");
		}
		return sb.toString();
	}
		
	public String findExpertByPositionName(Map<String,Object>map){
		list=(List<String>) map.get("positionName");
		if(!list.isEmpty()){
			str="SELECT exp_expert_info.* "
					+"FROM exp_expert_info "
					+"INNER JOIN exp_expert_position "
					+"ON exp_expert_info.expert_id=exp_expert_position.expert_id "
					+"INNER JOIN exp_positions "
					+"ON exp_expert_position.position_id=exp_positions.position_id "
					+"WHERE exp_positions.position_status IN(";
			sb=new StringBuilder(str);
			for(String val:list)
				sb.append("'"+val+"'").append(',');
			sb.deleteCharAt(sb.length()-1);
			sb.append(") AND expert_state IS NOT FALSE");
		}
		return sb.toString();
	}
}
