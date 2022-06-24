package com.testspec.demo.domain.model.supplier

import com.testspec.demo.domain.model.supplier.type.Description
import com.testspec.demo.domain.model.supplier.type.SupplierName

/**
 * 納品先
 */
class Supplier(
    val supplierId: Int,
    val supplierName: SupplierName,
    val description: Description
) {
}