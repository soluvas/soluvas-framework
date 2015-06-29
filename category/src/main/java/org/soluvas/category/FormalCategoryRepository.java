package org.soluvas.category;

import java.util.Optional;

public interface FormalCategoryRepository {

	Optional<FormalCategory> findOne(long googleId);

}