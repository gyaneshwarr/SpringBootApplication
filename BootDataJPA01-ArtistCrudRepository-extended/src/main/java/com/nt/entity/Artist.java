package com.nt.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@Table(name="Artist_table")
@NoArgsConstructor
@RequiredArgsConstructor
public class Artist {

	@Id
	@SequenceGenerator(name = "gen1",sequenceName = "ANO_SEQ",initialValue = 28,allocationSize = 1)
	@GeneratedValue(generator = "gen1",strategy = GenerationType.SEQUENCE)
	//@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer aid;
	
	@NonNull
	@Column(name="Artist_name")
	private String aname;
	
	@NonNull
	@Column(name="Artist_Role")
	private String arole;
	
	@NonNull
	@Column(name="Artist_Salary")
	private Double asal;
	
}
