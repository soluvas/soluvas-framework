package com.soluvas.story;

import java.util.List;

import org.soluvas.data.repository.PagingAndSortingRepository;

public interface StoryRepository extends PagingAndSortingRepository<Story, String> {

	public <S extends Story> S findOneByPartialId(String partialId);
	
	public List<Story> findAllByOwnerId(String ownerId);

	//	public abstract Story findOne(String _id);

//	public abstract PersonCommentProduct findOneByCommentId(String commentId);

//	public abstract List<Story> findAll();
//
//	public abstract List<Story> findBySubjectStatus(String subject,
//			com.soluvas.story.OldStory.Status status);
//
//	public abstract List<Story> findBySubject(String subject);
//
//	public abstract String getNamespace();
//
//	public abstract void upsert(Story story);
//
//	public abstract void insert(Story story);

}
