package com.atelier.dto.responseDto;


import com.atelier.entity.ShippingAddrEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
// RequestDto는 클라이언트에서 값을 받아올 때 사용되며,
// 서비스 혹은 DAO에서 처리되기 위한 toEntity 메소드를 가지고 있다
public class ShippingAddReponseDto{
	
	public ShippingAddReponseDto(ShippingAddrEntity shippingAddEntity){
		this.saId = shippingAddEntity.getSaId();
		this.saName = shippingAddEntity.getSaName();
		this.saPost = shippingAddEntity.getSaPost();
		this.saAddrHead = shippingAddEntity.getSaAddrHead();
		this.saAddrDetail = shippingAddEntity.getSaAddrDetail();
		this.saDefaultYn = shippingAddEntity.isSaDefaultYn();
	}
	
	private Long saId;
	private String saName;
	private String saPost;
	private String saAddrHead;
	private String saAddrDetail;
	private boolean saDefaultYn;
	
}
