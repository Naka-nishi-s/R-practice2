package com.example.demo.repository;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.User;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

@Repository
public class SampleRepository {
	
	@Autowired
	private EntityManagerFactory entityManagerFactory;
	
	// findAll()でUserのデータを取り出し、List型に代入する処理を定義している
	@SuppressWarnings("unchecked")
	public List<User> findAll() {

		
		// userListの定義
		List<User> userList = null;
		
		// EntityManagerの開始
		// EntityManagerは「DB操作パッケージ」のようなもの
		EntityManager entityManager = entityManagerFactory.createEntityManager();


	    try {
	        // トランザクションの開始
	        entityManager.getTransaction().begin();

	        // Userエンティティから全てのデータを取得し、userListに代入
	        // createQueryは本来createQuery("Select * FROM User")やcreateQuery("Select u.name FROM User u")と記述するが、
	        // 「SELECT *」の場合は省略して「FROM Uuser」と書くことができる
	        userList = entityManager.createQuery("from User").getResultList();
	        
	        // トランザクションのコミット（データベースへの変更を確定）
	        entityManager.getTransaction().commit();

	    } catch (Exception e) {
	        // エラーがあればロールバック（データベースへの変更を取り消し）
	        entityManager.getTransaction().rollback();
	        
	        // エラーを吐く（エラーの詳細情報を出力）
	        e.printStackTrace();
	    } finally {
	        // EntityManagerの終了（リソースの解放）
	        entityManager.close();
	    }
	    
	    // 取得したUserエンティティのリストを返す
	    // 失敗時はnull, 成功時はuserのデータが入ったList
	    return userList;
	}
}
