package spc.vision.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spc.vision.models.TodoItem;

import java.util.List;

@Repository
public interface TodoItemRepository extends JpaRepository<TodoItem,Long> {

    public List<TodoItem> findAllByOrderByIdDesc();
}
