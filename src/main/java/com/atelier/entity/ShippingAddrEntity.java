package com.atelier.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@DynamicInsert // (insert 시 null인 필드 제외) -> db의 컬럼은 not null로 잡고, default 값을 설정하여 해당 값 설정 가능
@Table(name = "SHIPPING_ADDR")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class ShippingAddrEntity extends BaseEntity{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "SA_ID")
	private Long saId;
	
	@Column(name = "SA_EMAIL", length = 50, nullable = false, columnDefinition = "varchar(50) ''")
	private Long saEmail;
	
	@Column(name = "SA_NAME", length = 30, nullable = false, columnDefinition = "varchar(30) ''")
	private String saName;
	
	@Column(name = "SA_POST", length = 50, nullable = false, columnDefinition = "varchar(50) ''")
	private String saPost;
	
	@Column(name = "SA_ADDR_HEAD", length = 50, nullable = false, columnDefinition = "varchar(50) ''")
	private Integer saAddrHead;
	
	@Column(name = "SA_ADDR_DETAIL", length = 50, nullable = false, columnDefinition = "varchar(50) ''")
	private Integer saAddrDetail;
	
	@Column(name = "SA_DAFAULT_YN", nullable = false, columnDefinition = "integer default 0")
	private Integer saDafaultYn;
	
}
