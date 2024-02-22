// import React from 'react';
import { Routes, Route } from 'react-router-dom';
import LoginPage from './components/LoginPage';
import Home from './components/Home';
import Profile from './components/Profile';
import SignUp from './components/SignUp';
// import { ErrorBoundary } from 'react-error-boundary';
import {lazy,Suspense} from 'react';
// import LargeData from './components/LargeData';
const LargeData = lazy(() =>import('./components/LargeData'))
function App() {
  return (
    <>
        <Routes>
            <Route path="/" element={<Profile />}/>
            <Route index element={<Profile />} />
            <Route path="home" element={<Home />} />
            <Route path="register" element={<SignUp />} />
            <Route path="largedata" element={<Suspense fallback={<p>loading.........................................</p>}><LargeData /></Suspense>}/>
        </Routes>
    </>
  );
}

export default App;
