package org.zerock.board.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.zerock.board.entity.Board;
import org.zerock.board.entity.Reply;

import java.util.List;

public interface ReplyRepository extends JpaRepository<Reply, Long> {

    // 게시물 삭제시 댓글도 같이 삭제
    @Modifying
    @Query("delete from Reply r where r.board.bno = :bno")
    void deleteByBno(Long bno);

    // 게시물 가져올 때 댓글 목록 가져오기
    List<Reply> getRepliesByBoardOrderByRno(Board board);

}