package org.zerock.domain;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class SampleVOList {
	
	private List<SampleVO> list;
	
	public SampleVOList() {
		list = new ArrayList<>();
	}
}
