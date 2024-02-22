import PropTypes from 'prop-types';
import './CollectionImg.jsx'
export default function CollectionImd({ image }) {
    return (
            <img src={image} alt="..." style={{ width: '200px', height: '200px' }} />
    );
}

CollectionImd.propTypes = {
    image: PropTypes.string.isRequired // Validate image prop
};
