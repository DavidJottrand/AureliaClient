package dj.aurelia.aureliaclient.security.repository;

import dj.aurelia.aureliaclient.domain.security.Authority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorityRepository extends JpaRepository<Authority, Long> {

    Authority findByName (String name);
  
}
