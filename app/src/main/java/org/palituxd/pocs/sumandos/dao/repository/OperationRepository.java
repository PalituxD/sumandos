package org.palituxd.pocs.sumandos.dao.repository;

import org.palituxd.pocs.sumandos.dao.entity.OperationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OperationRepository extends JpaRepository<OperationEntity, Long> {

}