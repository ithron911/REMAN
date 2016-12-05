package hu.uni.reman.persist.mysql;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
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

public abstract class FeedbackDAOImpl implements FeedbackDao {
	private SqlSessionFactory sqlSessionFactory;

	public FeedbackDAOImpl(String configPath, String host, int port, String db, String user, String pass)
			throws FileNotFoundException {
		File configFile = new File(configPath);
		InputStream inputStream = new FileInputStream(configFile);
		String url = String.format("jdbc:mysql://%s:%s/%s?allowMultiQueries=true", host, port, db);
		Properties props = new Properties();
		props.put("driver", "com.mysql.jdbc.Driver");
		props.put("url", url);
		props.put("username", user);
		props.put("password", pass);
		this.sqlSessionFactory = (new SqlSessionFactoryBuilder()).build(inputStream, props);
	}

	public int insertFeedback(Feedback feedback) throws InsertFailedException {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		FeedbackMapper feedbackMapper = sqlSession.getMapper(FeedbackMapper.class);

		int id = 0;
		try {
			feedbackMapper.insertFeedback(feedback);

			id = feedback.getId();
			if (id == 0) {
				throw new InsertFailedException("Insertion failed!");
			}
		} finally {
			sqlSession.close();
		}


		return id;
	}

	@Override
	public void updateFeedback(Feedback feedback) throws UpdateFailedException {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		FeedbackMapper feedbackMapper = sqlSession.getMapper(FeedbackMapper.class);

		try {
			feedbackMapper.updateFeedback(feedback);
		} finally {
			sqlSession.close();
		}
	}

	public Feedback getAllFeedbacks(int id) throws NoResultException {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		FeedbackMapper feedbackMapper = sqlSession.getMapper(FeedbackMapper.class);
		Feedback feedback = null;

		try {
			feedback = feedbackMapper.getFeedback(id);
			
			if (feedback == null) {
				throw new NoResultException("The query has no result with id: " + id);
			}
		} finally {
			sqlSession.close();
		}
		
		return feedback;
	}

	public void deleteFeedback(int id) throws DeleteFailedException {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		FeedbackMapper feedbackMapper = sqlSession.getMapper(FeedbackMapper.class);

		try {
			feedbackMapper.deleteFeedback(id);
		} finally {
			sqlSession.close();
		}
	}
}
