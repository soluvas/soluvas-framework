/*
 * Copyright 2008-2012 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.soluvas.data.domain;

import java.io.Serializable;

import org.soluvas.data.domain.Sort.Direction;

/**
 * A custom implementation of {@link Pageable} that uses offset (aka first record index) instead of
 * page number. Useful for usage in Wicket SortableDataProvider.
 * @author atang 
 */
public class PageOffsetRequest implements Pageable, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private final long pageOffset;
	private final long size;
	private final Sort sort;

	/**
	 * Creates a new {@link PageOffsetRequest}. Pages are zero indexed, thus providing 0 for {@code page} will return the first
	 * page.
	 * 
	 * @param size
	 * @param page
	 */
	public PageOffsetRequest(long pageOffset, long size) {
		this(pageOffset, size, null);
	}

	/**
	 * Creates a new {@link PageOffsetRequest} with sort parameters applied.
	 * 
	 * @param page
	 * @param size
	 * @param direction
	 * @param properties
	 */
	public PageOffsetRequest(long pageOffset, long size, Direction direction, String... properties) {
		this(pageOffset, size, new Sort(direction, properties));
	}

	/**
	 * Creates a new {@link PageOffsetRequest} with sort parameters applied.
	 * 
	 * @param page
	 * @param size
	 * @param sort
	 */
	public PageOffsetRequest(long pageOffset, long size, Sort sort) {
		if (0 > pageOffset) {
			throw new IllegalArgumentException("Page offset must not be less than zero!");
		}

		if (0 >= size) {
			throw new IllegalArgumentException("Page size must not be less than or equal to zero!");
		}

		this.pageOffset = pageOffset;
		this.size = size;
		this.sort = sort;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.springframework.data.domain.Pageable#getPageSize()
	 */
	@Override
	public long getPageSize() {
		return size;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.springframework.data.domain.Pageable#getPageNumber()
	 */
	@Override
	public long getPageNumber() {
		return pageOffset / getPageSize();
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.springframework.data.domain.Pageable#getFirstItem()
	 */
	@Override
	public long getOffset() {
		return pageOffset;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.springframework.data.domain.Pageable#getSort()
	 */
	@Override
	public Sort getSort() {
		return sort;
	}
	
	@Override
	public Pageable andSort(Sort tailSort) {
		final Sort newSort = sort != null ? sort.and(tailSort) : tailSort;
		return new PageOffsetRequest(pageOffset, size, newSort);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(final Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof PageOffsetRequest)) {
			return false;
		}

		PageOffsetRequest that = (PageOffsetRequest) obj;

		boolean pageEqual = this.pageOffset == that.pageOffset;
		boolean sizeEqual = this.size == that.size;

		boolean sortEqual = this.sort == null ? that.sort == null : this.sort.equals(that.sort);

		return pageEqual && sizeEqual && sortEqual;
	}

	@Override
	public int hashCode() {
		int result = 17;

		result = (int) (31 * result + pageOffset);
		result = (int) (31 * result + size);
		result = 31 * result + (null == sort ? 0 : sort.hashCode());

		return result;
	}
	
	@Override
	public String toString() {
		return "PageOffsetRequest [pageOffset=" + pageOffset + ", size=" + size
				+ ", " + (sort != null ? "sort=" + sort : "") + "]";
	}

}
