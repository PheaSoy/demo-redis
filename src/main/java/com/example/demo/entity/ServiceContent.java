package com.example.demo.entity;

import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="service_content")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ServiceContent {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "service_id", length = 100, nullable = false)
	String serviceId;


	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "content_id", referencedColumnName = "id", nullable = false)
	private ContentConfig content;
}