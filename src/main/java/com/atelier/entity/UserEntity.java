package com.atelier.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;

import com.google.common.base.Strings;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
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
	
	@PrePersist
	// JPA의 영속성이 적용되기 전 실행되는 메소드 (@DynamicInsert 보다 직관적이고, Entity에 null 값이 아닌 "" 가 남기 때문에 더 좋다)
	// @PrePersist, @PostPersist, @PreRemove, @PostRemove, @PreUpdate, @PostUpdate, @PostLoad 가 추가로 있다.
	public void prePersist() {
		this.cmState = (Strings.isNullOrEmpty(cmState)) ? "Y" : this.cmState;
		this.cmPfphoto = (Strings.isNullOrEmpty(cmPfphoto)) ? "" : this.cmPfphoto;
	}
}
