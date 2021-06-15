package com.atelier.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;

import com.atelier.dto.responseDto.ShippingAddReponseDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@DynamicInsert // (insert 시 null인 필드 제외) -> db의 컬럼은 not null로 잡고, default 값을 설정하여 해당 값 설정 가능
@Table(name = "SHIPPING_ADDR")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
// fetch = FetchType.LAZY를 사용하면 꼭 ToString에서 exclude 해 주자.
// 만약 ShippingAddrEntity만 필요할 때 ToString을 그냥 쓰면 saEmail 도 필요하게 되므로 ToString을 위한 DB조회가 이루어지기 때문이다.
@ToString(exclude = {"userEntity"}) 

public class ShippingAddrEntity extends BaseEntity{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "SA_ID")
	private Long saId;
	
	@Column(name = "SA_NAME", length = 30, nullable = false, columnDefinition = "varchar(30) default ''")
	private String saName;
	
	@Column(name = "SA_POST", length = 20, nullable = false, columnDefinition = "varchar(20) default ''")
	private String saPost;
	
	@Column(name = "SA_ADDR_HEAD", length = 50, nullable = false, columnDefinition = "varchar(50) default ''")
	private String saAddrHead;
	
	@Column(name = "SA_ADDR_DETAIL", length = 50, nullable = false, columnDefinition = "varchar(50) default ''")
	private String saAddrDetail;
	
	@Column(name = "SA_DAFAULT_YN", nullable = false, columnDefinition = "varchar(1) default 'N'")
	@org.hibernate.annotations.Type(type="yes_no")
	private boolean saDefaultYn;
	
	// 1명의 유저는 최대 N개의 배송지 정보를 저장할 수 있다.
	// 배송지와 1 : N 관계 (JPA에서 연관관계를 해석할 때, PK를 기준으로 잡고 모델링한다)
	// FetchType.EAGER는 기본설정이며, 본 Entity를 조회 시 연관된 모든 테이블을 조회하는 설정 (자동으로 조회 시 join을 하여 가져온다)
	// FetchType.LAZY는 본 Entity를 조회 시 연관된 모든 테이블을 조회하는 설정 (@Transaction을 통해서 조인을 사용하지 않고 각 테이블마다 조회를 따로 한다)
	@ManyToOne (targetEntity = UserEntity.class, fetch = FetchType.LAZY)
	//@JoinColumn(name = "SA_EMAIL")
	private UserEntity userEntity;
	
}
