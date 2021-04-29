package com.ysmin.blog.repository;

import com.sun.xml.bind.v2.model.core.ID;
import com.ysmin.blog.model.Reply;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReplyRepository extends JpaRepository<Reply, Integer> {
}
