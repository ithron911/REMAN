package hu.uni.reman.persist.mysql;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Collection;
import java.util.Properties;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import dao.FeedbackDao;
import exceptions.DeleteFailedException;
import exceptions.InsertFailedException;
import exceptions.NoResultException;
import exceptions.UpdateFailedException;
import hu.uni.reman.persist.mysql.mapper.FeedbackMapper;
import model.Feedback;

public class FeedbackDAOImpl implements FeedbackDao {
	
	private SqlSessionFactory sqlSessionFactory;
	
	public FeedbackDAOImpl(String configPath, String host, int port, String db, String user, String pass, String connectionUrl)
			throws FileNotFoundException {
		File configFile = new File(configPath);
		InputStream inputStream = new FileInputStream(configFile);
		String url = String.format(connectionUrl, host, port, db);
		Properties props = new Properties();
		props.put("driver", "com.mysql.jdbc.Driver");
		props.put("url", url);
		props.put("username", user);
		props.put("password", pass);
		this.sqlSessionFactory = (new SqlSessionFactoryBuilder()).build(inputStream, props);
	}

	@Override
	public void insertFeedback(Feedback feedback) throws InsertFailedException {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		FeedbackMapper feedbackMapper = sqlSession.getMapper(FeedbackMapper.class);

		try {
			Collection<Feedback> feedbacks = feedbackMapper.getAllFeedbacks();
			for(Feedback feedb : feedbacks) {
				if(feedb.getId() == feedback.getId()) {
					throw new InsertFailedException("A feedback with this id exists:" + feedback.getId());
				}
			}
			feedbackMapper.insertFeedback(feedback);
		} finally {
			sqlSession.close();
		}
	}

	@Override
	public void updateFeedback(Feedback feedback) throws UpdateFailedException {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		FeedbackMapper feedbackMapper = sqlSession.getMapper(FeedbackMapper.class);

		boolean isFeedbackExits = false;
		Collection<Feedback> feedbacks = feedbackMapper.getAllFeedbacks();
		for(Feedback feedb : feedbacks) {
			if(feedb.getId() == feedback.getId()) {
				isFeedbackExits = true;
				break;
			}
		}
		
		if(isFeedbackExits == false) {
			throw new UpdateFailedException("A feedback with this id does not exists:" + feedback.getId());
		}
		try {
			feedbackMapper.updateFeedback(feedback);
		} finally {
			sqlSession.close();
		}
	}

	@Override
	public Feedback getFeedback(int id) throws NoResultException {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		FeedbackMapper feedbackMapper = sqlSession.getMapper(FeedbackMapper.class);
		Feedback feedback = null;
		
		try {
			feedback = feedbackMapper.getFeedback(id);
			
			if(feedback == null) {
				throw new NoResultException("The query has no result with id: " + id);
			}
		} finally {
			sqlSession.close();
		}
		
		return feedback;
	}
	
	@Override
	public Collection<Feedback> getAllFeedback() throws NoResultException {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		FeedbackMapper feedbackMapper = sqlSession.getMapper(FeedbackMapper.class);
		Collection<Feedback> allFeedbacks = null;

		try {
			allFeedbacks = feedbackMapper.getAllFeedbacks();
			
			if (allFeedbacks == null) {
				throw new NoResultException("The query has no result, the table is empty!");
			}
			
		} finally {
			sqlSession.close();
		}
		
		return allFeedbacks;
	}

	@Override
	public void deleteFeedback(int id) throws DeleteFailedException {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		FeedbackMapper feedbackMapper = sqlSession.getMapper(FeedbackMapper.class);

		boolean isFeedbackExits = false;
		Collection<Feedback> feedbacks = feedbackMapper.getAllFeedbacks();
		for(Feedback feedb : feedbacks) {
			if(id == feedb.getId()) {
				isFeedbackExits = true;
				break;
			}
		}
		
		if(isFeedbackExits == false) {
			throw new DeleteFailedException("A feedback with this id does not exists:" + id);
		}
		
		try {
			feedbackMapper.deleteFeedback(id);
		} finally {
			sqlSession.close();
		}
	}
}
