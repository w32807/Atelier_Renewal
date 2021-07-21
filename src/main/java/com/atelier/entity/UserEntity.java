package com.atelier.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;

import com.atelier.enums.Roles;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@DynamicInsert(value = true) // (insert 시 null인 필드 제외) -> db의 컬럼은 not null로 잡고, default 값을 설정하여 해당 값 설정 가능
@Table(name = "COMMON_MEMBER")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@ToString
public class UserEntity extends BaseEntity{
	
	@Id
	@Column(name = "CM_EMAIL", length = 50, nullable = false, columnDefinition = "varchar(50) default ''")
	private String cmEmail;
	
	@Column(name = "CM_PWD", length = 100, nullable = false, columnDefinition = "varchar(100) default ''")
	@Setter
	private String cmPwd;
	
	@Column(name = "CM_NAME", length = 30, nullable = false, columnDefinition = "varchar(30) default ''")
	private String cmName;
	
	@Column(name = "CM_NICK", length = 30, nullable = false, columnDefinition = "varchar(30) default ''")
	private String cmNick;
	
	@Column(name = "CM_PHONE1", nullable = false, columnDefinition = "integer default 0")
	private String cmPhone1;
	
	@Column(name = "CM_PHONE2", nullable = false, columnDefinition = "integer default 0")
	private String cmPhone2;
	
	@Column(name = "CM_PHONE3", nullable = false, columnDefinition = "integer default 0")
	private String cmPhone3;
	
	@Column(name = "CM_STATE", length = 1, nullable = false, columnDefinition = "varchar(1) default ''")
	private String cmState;
	
	@Column(name = "CM_PFPHOTO", length = 100, nullable = false, columnDefinition = "varchar(100) default ''")
	private String cmPfphoto;
	
	@ElementCollection(fetch = FetchType.LAZY) // 컬렉션 객체임을 알려주는 Annotation
	@Builder.Default
	@Enumerated(EnumType.STRING) // 기본으로 Enum 값이 컬럼에 들어가면 선언된 순서인 정수값이 들어간다.
	private Set<Roles> roleSet = new HashSet<>();
	
	public void addRole(Roles roles) {
		roleSet.add(roles);
	}
}
