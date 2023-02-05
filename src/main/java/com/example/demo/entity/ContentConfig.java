package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="content_config")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ContentConfig{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "title", length = 255, nullable = false)
	String title;

	@Column(name = "title_kh", length = 500, nullable = false)
	String titleKh;

	@Column(name = "content")
	String content;

	@Column(name = "content_kh")
	String contentKh;
}
