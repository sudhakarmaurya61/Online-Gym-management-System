/**
 * 
 */
package com.wipro.online.gym.management.system.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wipro.online.gym.management.system.model.Package;

/**
 * 
 */
public interface PackageRepository extends JpaRepository<Package, Integer> {

	Package getPackageById(Integer packageId);

}
