import './style.css';
import { useEffect, useState } from 'react';
import StepHeaders from './StepsHeader';
import ProductsList from './ProductList';
import { Product } from './types';
import { fetchProduct } from '../api';


function Orders(){

    const[products, setProducts] = useState<Product[]>([])
    
    console.log(products)

    useEffect (() =>{
        fetchProduct().then(
            response => setProducts(response.data)
        ).catch(
            error => console.log(error))
    }, [])

    return (
       <div className="orders-container">
           <StepHeaders />
           <ProductsList products={products} />
        </div>
    )
}

export default Orders;