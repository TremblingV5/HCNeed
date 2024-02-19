import {CompanyList} from "@/components/CompanyList/CompanyList";
import {useListCompany} from "@/api/api";

export default function Company () {
  const result = useListCompany({});

  return (
    <div>
      <CompanyList />
    </div>
  );
};