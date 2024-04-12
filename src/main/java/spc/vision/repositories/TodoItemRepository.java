package spc.vision.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import spc.vision.models.TodoItem;

import java.util.Arrays;
import java.util.List;

@Repository
public interface TodoItemRepository extends JpaRepository<TodoItem,Long> {

    public List<TodoItem> findAllByOrderByIdDesc();

    @Query("SELECT ti FROM TodoItem ti ORDER BY ti.id DESC")
    public List<TodoItem> findLast20();

    TodoItem findTopByOrderByIdDesc();
}
