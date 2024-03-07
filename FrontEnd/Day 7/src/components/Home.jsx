import { useContext } from "react";
// import Navbar from "./Navbar";
import Layout from "./Layout";
import { EmailContext } from "./EmailContext";

export default function Home() {
  const { email } = useContext(EmailContext);

  return (
    <>
      <Layout email={email} />
      {/* <Navbar /> */}
    </>
  );
}
