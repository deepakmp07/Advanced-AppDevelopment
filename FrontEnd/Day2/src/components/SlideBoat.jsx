// import React from 'react';
import CollectionImd from './CollectionImg';
import boating from '../data/data';
import '../css/SlideBoat.css'; // Import CSS file for styling

export default function SlideBoat() {
    return (
        <>
        <div className="marquee">
            <marquee>
                {boating.map((image, i) => <CollectionImd key={i} image={image} />)}
            </marquee>
        </div>
         <div className="marquee marquee2">
         <marquee>
             {boating.map((image, i) => <CollectionImd key={i} image={image} />)}
         </marquee>
     </div>
     </>
    );
}
