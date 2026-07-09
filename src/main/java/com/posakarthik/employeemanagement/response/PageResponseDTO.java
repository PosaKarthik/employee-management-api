package com.posakarthik.employeemanagement.response;

import java.util.List;

import com.posakarthik.employeemanagement.dto.EmployeeResponseDTO;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description="Paginated response")
public class PageResponseDTO<T> {
	
	private List<T> content;
	@Schema(description="Current page number",example="0")
	private int pageNumber;
	
	@Schema(description="Page size",example="5")
	private int pageSize;
	
	@Schema(description="Total number of records",example="20")
	private long totalElements;
	
	@Schema(description="Total number of pages",example="5")
	private int totalPages;
	
	@Schema(description="Whether this is the first page",example="true")
	private boolean first;
	
	@Schema(description="Whether this is the last page",example="false")
	private boolean last;
	
	@Schema(description="Whether there is a next page",example="true")
	private boolean hasNext;
	
	@Schema(description="Whether there is a previous page",example="false")
	private boolean hasPrevious;
}
