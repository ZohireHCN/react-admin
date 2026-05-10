import { Routes, Route, Navigate } from 'react-router-dom';
import Layout from './Layout';
import ResourcePage from './ResourcePage';

export default function AppRouter({ config }) {
  return (
    <Layout config={config}>
      <Routes>
        <Route path="/" element={<div>Dashboard</div>} />

        {config.resources?.map(resource => (
          <Route
            key={resource.name}
            path={`/${resource.name}`}
            element={<ResourcePage resource={resource} />}
          />
        ))}

        <Route path="*" element={<Navigate to="/" replace />} />
      </Routes>
    </Layout>
  );
}